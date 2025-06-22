#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <ctype.h>

// 函数声明
void showMenu();
void basicCalculation();
void advancedCalculation();
double getNumber();
char getOperator();
double calculate(double num1, double num2, char op);
double advancedCalculate(char op, double num);
void clearScreen();
int confirmContinue();

// 主函数
int main() {
    int choice;

    do {
        clearScreen();
        showMenu();

        printf("请输入你的选择 (1-3): ");
        if (scanf("%d", &choice) != 1) {
            // 输入非数字处理
            while (getchar() != '\n'); // 清空输入缓冲区
            printf("输入无效，请重试！\n");
            system("pause");
            continue;
        }

        switch (choice) {
            case 1:
                basicCalculation();
                break;
            case 2:
                advancedCalculation();
                break;
            case 3:
                printf("感谢使用计算器，再见！\n");
                return 0;
            default:
                printf("无效选择，请重试！\n");
        }

        system("pause");
    } while (confirmContinue());

    return 0;
}

// 显示菜单
void showMenu() {
    printf("===== 简易计算器 =====\n");
    printf("1. 基本计算 (加减乘除)\n");
    printf("2. 高级计算 (三角函数、幂运算等)\n");
    printf("3. 退出程序\n");
    printf("======================\n");
}

// 基本计算功能
void basicCalculation() {
    clearScreen();
    printf("===== 基本计算 =====\n");

    double num1 = getNumber("请输入第一个数字: ");
    char op = getOperator();
    double num2 = getNumber("请输入第二个数字: ");

    double result = calculate(num1, num2, op);
    printf("计算结果: %.2f %c %.2f = %.2f\n", num1, op, num2, result);
}

// 高级计算功能
void advancedCalculation() {
    clearScreen();
    printf("===== 高级计算 =====\n");
    printf("可用操作:\n");
    printf("s: 正弦(sin)\n");
    printf("c: 余弦(cos)\n");
    printf("t: 正切(tan)\n");
    printf("l: 自然对数(ln)\n");
    printf("e: 指数(e^x)\n");
    printf("p: 幂运算(x^y)\n");
    printf("r: 平方根(sqrt)\n");

    char op;
    printf("请输入操作符: ");
    while (getchar() != '\n'); // 清空输入缓冲区
    if (scanf("%c", &op) != 1) {
        printf("输入无效！\n");
        return;
    }

    op = tolower(op); // 转换为小写

    double num;
    if (op == 'p') {
        // 幂运算需要两个数字
        num = getNumber("请输入底数: ");
        double exponent = getNumber("请输入指数: ");
        printf("计算结果: %.2f^%.2f = %.2f\n", num, exponent, pow(num, exponent));
    } else {
        num = getNumber("请输入数字: ");
        double result = advancedCalculate(op, num);
        printf("计算结果: %.2f\n", result);
    }
}

// 获取数字输入
double getNumber(const char* prompt) {
    double num;
    while (1) {
        printf(prompt);
        if (scanf("%lf", &num) == 1) {
            return num;
        } else {
            // 输入无效处理
            while (getchar() != '\n'); // 清空输入缓冲区
            printf("无效输入，请输入数字！\n");
        }
    }
}

// 获取操作符
char getOperator() {
    char op;
    printf("请输入操作符(+,-,*,/): ");
    while (1) {
        if (scanf(" %c", &op) == 1) {
            if (op == '+' || op == '-' || op == '*' || op == '/') {
                return op;
            } else {
                printf("无效操作符，请重新输入: ");
            }
        } else {
            // 输入无效处理
            while (getchar() != '\n'); // 清空输入缓冲区
            printf("无效输入，请输入操作符: ");
        }
    }
}

// 基本计算实现
double calculate(double num1, double num2, char op) {
    switch (op) {
        case '+': return num1 + num2;
        case '-': return num1 - num2;
        case '*': return num1 * num2;
        case '/':
            if (num2 == 0) {
                printf("错误：除数不能为零！\n");
                exit(1);
            }
            return num1 / num2;
        default:
            printf("无效操作符！\n");
            exit(1);
    }
}

// 高级计算实现
double advancedCalculate(char op, double num) {
    switch (op) {
        case 's': return sin(num);
        case 'c': return cos(num);
        case 't': return tan(num);
        case 'l':
            if (num <= 0) {
                printf("错误：自然对数的参数必须为正数！\n");
                exit(1);
            }
            return log(num);
        case 'e': return exp(num);
        case 'r':
            if (num < 0) {
                printf("错误：不能计算负数的平方根！\n");
                exit(1);
            }
            return sqrt(num);
        default:
            printf("无效操作符！\n");
            exit(1);
    }
}

// 清屏函数
void clearScreen() {
#ifdef _WIN32
    system("cls");
#else
    system("clear");
#endif
}

// 确认是否继续
int confirmContinue() {
    char choice;
    printf("\n是否继续使用计算器? (y/n): ");
    while (getchar() != '\n'); // 清空输入缓冲区
    if (scanf("%c", &choice) == 1) {
        return tolower(choice) == 'y';
    }
    return 0;
}