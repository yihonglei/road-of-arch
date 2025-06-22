#include <iostream>
#include <string>
#include <stack>
#include <queue>
#include <map>
#include <cmath>
#include <sstream>
#include <cctype>
#include <stdexcept>

// 函数声明
double evaluateExpression(const std::string& expression);
std::queue<std::string> infixToRPN(const std::string& infix);
double applyOperation(double a, double b, const std::string& op);
double applyFunction(const std::string& func, double value);
bool isFunction(const std::string& token);
int precedence(const std::string& op);
bool isOperator(const std::string& token);
std::vector<std::string> tokenize(const std::string& input);

// 变量存储
std::map<std::string, double> variables;

int main() {
    std::string input;
    std::cout << "=== C++ 高级计算器 ===" << std::endl;
    std::cout << "支持 +-*/^ 运算、函数(sin/cos/tan/ln/exp/sqrt)、变量(a=5)" << std::endl;
    std::cout << "输入 'q' 退出" << std::endl;

    while (true) {
        std::cout << "\n计算表达式: ";
        std::getline(std::cin, input);

        // 处理退出命令
        if (input == "q" || input == "Q") break;

        try {
            // 检查是否为变量赋值
            size_t equalPos = input.find('=');
            if (equalPos != std::string::npos) {
                std::string varName = input.substr(0, equalPos);
                // 去除变量名前后空格
                varName.erase(0, varName.find_first_not_of(" \t"));
                varName.erase(varName.find_last_not_of(" \t") + 1);

                if (!std::all_of(varName.begin(), varName.end(), [](char c) {
                    return std::isalpha(c) || c == '_';
                })) {
                    throw std::invalid_argument("无效的变量名，只能包含字母和下划线");
                }

                std::string expr = input.substr(equalPos + 1);
                double value = evaluateExpression(expr);
                variables[varName] = value;
                std::cout << varName << " = " << value << std::endl;
            } else {
                double result = evaluateExpression(input);
                std::cout << "结果: " << result << std::endl;
            }
        } catch (const std::exception& e) {
            std::cerr << "错误: " << e.what() << std::endl;
        }
    }

    return 0;
}

// 解析并计算表达式
double evaluateExpression(const std::string& expression) {
    std::queue<std::string> rpn = infixToRPN(expression);
    std::stack<double> stack;

    while (!rpn.empty()) {
        std::string token = rpn.front();
        rpn.pop();

        if (isOperator(token)) {
            if (stack.size() < 2) {
                throw std::runtime_error("操作数不足");
            }
            double b = stack.top(); stack.pop();
            double a = stack.top(); stack.pop();
            stack.push(applyOperation(a, b, token));
        } else if (isFunction(token)) {
            if (stack.size() < 1) {
                throw std::runtime_error("函数缺少参数");
            }
            double val = stack.top(); stack.pop();
            stack.push(applyFunction(token, val));
        } else {
            // 检查是否是变量
            if (variables.find(token) != variables.end()) {
                stack.push(variables[token]);
            } else {
                // 尝试转换为数字
                try {
                    stack.push(std::stod(token));
                } catch (const std::exception&) {
                    throw std::invalid_argument("无效的令牌: " + token);
                }
            }
        }
    }

    if (stack.size() != 1) {
        throw std::runtime_error("表达式格式错误");
    }

    return stack.top();
}

// 中缀表达式转逆波兰表达式
std::queue<std::string> infixToRPN(const std::string& infix) {
    std::vector<std::string> tokens = tokenize(infix);
    std::queue<std::string> output;
    std::stack<std::string> stack;

    for (const auto& token : tokens) {
        if (token == "(") {
            stack.push(token);
        } else if (token == ")") {
            while (!stack.empty() && stack.top() != "(") {
                output.push(stack.top());
                stack.pop();
            }
            if (stack.empty()) {
                throw std::runtime_error("括号不匹配");
            }
            stack.pop(); // 弹出左括号
            // 检查括号前是否是函数
            if (!stack.empty() && isFunction(stack.top())) {
                output.push(stack.top());
                stack.pop();
            }
        } else if (isFunction(token)) {
            stack.push(token);
        } else if (isOperator(token)) {
            while (!stack.empty() && isOperator(stack.top()) &&
                   (precedence(stack.top()) > precedence(token) ||
                    (precedence(stack.top()) == precedence(token) && token != "^"))) {
                output.push(stack.top());
                stack.pop();
            }
            stack.push(token);
        } else {
            // 操作数直接输出
            output.push(token);
        }
    }

    // 弹出剩余的操作符
    while (!stack.empty()) {
        if (stack.top() == "(" || stack.top() == ")") {
            throw std::runtime_error("括号不匹配");
        }
        output.push(stack.top());
        stack.pop();
    }

    return output;
}

// 执行运算操作
double applyOperation(double a, double b, const std::string& op) {
    if (op == "+") return a + b;
    if (op == "-") return a - b;
    if (op == "*") return a * b;
    if (op == "/") {
        if (b == 0) throw std::runtime_error("除数不能为零");
        return a / b;
    }
    if (op == "^") return std::pow(a, b);
    throw std::invalid_argument("不支持的运算符: " + op);
}

// 执行函数计算
double applyFunction(const std::string& func, double value) {
    if (func == "sin") return std::sin(value);
    if (func == "cos") return std::cos(value);
    if (func == "tan") return std::tan(value);
    if (func == "ln") {
        if (value <= 0) throw std::runtime_error("对数函数参数必须大于0");
        return std::log(value);
    }
    if (func == "exp") return std::exp(value);
    if (func == "sqrt") {
        if (value < 0) throw std::runtime_error("平方根函数参数不能为负");
        return std::sqrt(value);
    }
    throw std::invalid_argument("不支持的函数: " + func);
}

// 判断是否为函数
bool isFunction(const std::string& token) {
    static const std::string functions[] = {"sin", "cos", "tan", "ln", "exp", "sqrt"};
    for (const auto& func : functions) {
        if (token == func) return true;
    }
    return false;
}

// 获取运算符优先级
int precedence(const std::string& op) {
    if (op == "+" || op == "-") return 1;
    if (op == "*" || op == "/") return 2;
    if (op == "^") return 3;
    return 0;
}

// 判断是否为运算符
bool isOperator(const std::string& token) {
    return token == "+" || token == "-" || token == "*" || token == "/" || token == "^";
}

// 表达式分词
std::vector<std::string> tokenize(const std::string& input) {
    std::vector<std::string> tokens;
    std::string token;
    std::istringstream iss(input);

    for (size_t i = 0; i < input.length(); ++i) {
        char c = input[i];

        // 跳过空格
        if (std::isspace(c)) continue;

        // 数字（包括小数点和负数符号）
        if (std::isdigit(c) || c == '.' || (c == '-' &&
                                            (i == 0 || !std::isdigit(input[i-1]) && input[i-1] != ')'))) {
            token = c;
            while (i + 1 < input.length() && (std::isdigit(input[i+1]) || input[i+1] == '.')) {
                token += input[++i];
            }
            tokens.push_back(token);
        }
            // 变量名
        else if (std::isalpha(c) || c == '_') {
            token = c;
            while (i + 1 < input.length() && (std::isalnum(input[i+1]) || input[i+1] == '_')) {
                token += input[++i];
            }
            tokens.push_back(token);
        }
            // 括号或运算符
        else if (c == '(' || c == ')' || isOperator(std::string(1, c))) {
            tokens.push_back(std::string(1, c));
        } else {
            throw std::invalid_argument("非法字符: " + std::string(1, c));
        }
    }

    return tokens;
}