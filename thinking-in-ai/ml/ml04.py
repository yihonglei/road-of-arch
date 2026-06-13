# 示例：使用 Keras 快速构建一个简单的神经网络
from tensorflow import keras
from tensorflow.keras import layers

model = keras.Sequential([
    layers.Dense(64, activation='relu', input_shape=(input_dim,)), # 隐藏层1
    layers.Dropout(0.2), # 丢弃层，防止过拟合
    layers.Dense(32, activation='relu'), # 隐藏层2
    layers.Dense(1, activation='sigmoid') # 输出层，用于二分类
])

model.compile(optimizer='adam',
              loss='binary_crossentropy',
              metrics=['accuracy'])

model.summary() # 打印模型结构
# 之后可以使用 model.fit 进行训练