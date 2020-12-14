"""
主体窗口
"""
import pygame


class Screen:
    def __init__(self):
        self.width = 1200
        self.height = 600
        # 显示窗体
        self.screen = pygame.display.set_mode((self.width, self.height))
        # 设置主题
        pygame.display.set_caption("植物大战僵尸_简版_yhl")
        # 背景图片
        self.background_image = pygame.image.load("./material/image/background.png")
        # 设置背景图片大小
        self.scale_background_image = pygame.transform.scale(self.background_image, (self.width, self.height))
        # 获取图片的位置和大小
        self.scale_background_image_rect = self.scale_background_image.get_rect()
