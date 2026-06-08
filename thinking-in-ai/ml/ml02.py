import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, classification_report

def hello02(name):
    # =========================
    # 1. 构造可运行的测试数据
    # 场景：是否通过考试（1=通过，0=未通过）
    # 特征：学习时长、出勤率、作业完成率
    # =========================
    X = np.array([
        [2, 60, 50],
        [3, 65, 55],
        [4, 70, 65],
        [5, 75, 70],
        [6, 80, 75],
        [7, 85, 80],
        [8, 90, 85],
        [9, 92, 88],
        [10, 95, 90],
        [11, 97, 92],
        [1, 50, 40],
        [2, 55, 45],
        [3, 60, 50],
        [4, 65, 55],
        [5, 70, 60],
        [6, 75, 65],
        [7, 80, 70],
        [8, 85, 75],
        [9, 90, 80],
        [10, 95, 85]
    ])

    y = np.array([
        0, 0, 0, 0, 1,
        1, 1, 1, 1, 1,
        0, 0, 0, 0, 0,
        1, 1, 1, 1, 1
    ])

    # =========================
    # 2. 划分训练集和测试集
    # =========================
    X_train, X_test, y_train, y_test = train_test_split(
        X, y, test_size=0.3, random_state=42
    )

    # =========================
    # 3. 创建并训练模型
    # =========================
    model = LogisticRegression(max_iter=1000)
    model.fit(X_train, y_train)

    # =========================
    # 4. 进行预测
    # =========================
    y_pred = model.predict(X_test)

    # =========================
    # 5. 评估模型性能
    # =========================
    print(f"模型准确率：{accuracy_score(y_test, y_pred):.2f}")
    print("\n详细分类报告：")
    print(classification_report(y_test, y_pred))