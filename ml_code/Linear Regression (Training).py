import numpy as np
from numpy.typing import NDArray


class Solution:
    # 求导函数是已知的不是自编
    def get_derivative(
        self,
        model_prediction: NDArray[np.float64],
        ground_truth: NDArray[np.float64],
        N: int,
        X: NDArray[np.float64],
        desired_weight: int
    ) -> float:
        # note that N is just len(X)
        return -2 * np.dot(ground_truth - model_prediction, X[:, desired_weight]) / N

    def get_model_prediction(self, X: NDArray[np.float64], weights: NDArray[np.float64]) -> NDArray[np.float64]:
        return np.squeeze(np.matmul(X, weights))

    learning_rate = 0.01

    def train_model(
        self,
        X: NDArray[np.float64],
        Y: NDArray[np.float64],
        num_iterations: int,
        initial_weights: NDArray[np.float64]
    ) -> NDArray[np.float64]:
        for _ in range(num_iterations):
            model_prediction = self.get_model_prediction(X, initial_weights)

            # 计算损失函数相对于每个权重的导数
            d1 = self.get_derivative(model_prediction, Y, len(X), X, 0)
            d2 = self.get_derivative(model_prediction, Y, len(X), X, 1)
            d3 = self.get_derivative(model_prediction, Y, len(X), X, 2)
            # 使用梯度下降法，更新每个权重
            initial_weights[0] = initial_weights[0] - d1 * self.learning_rate
            initial_weights[1] = initial_weights[1] - d2 * self.learning_rate
            initial_weights[2] = initial_weights[2] - d3 * self.learning_rate

        return np.round(initial_weights, 5)


"""
该代码假设模型是一个线性模型,只有三个权重。
实现了一个简单的线性模型训练过程,使用梯度下降法来优化模型权重,使模型预测值与ground truth之间的差异最小化。
在每次迭代中,它计算损失函数相对于每个权重的导数,并根据导数值和学习率来更新权重。最终返回经过多次迭代后优化的权重值。

Input:
X = [[1, 2, 3], [1, 1, 1]]
Y = [6, 3]
num_iterations = 10
initial_weights = [0.2, 0.1, 0.6]

Output:
[0.50678, 0.59057, 1.27435]
"""
