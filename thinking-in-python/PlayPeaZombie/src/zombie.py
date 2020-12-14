"""
僵尸对象
"""
import pygame
import random

# 解决循环依赖导包方式之一
import src.bullet as bt


class Zombie:
    # 所有的僵尸信息
    zombie_list = []
    # 创建僵尸间隔
    interval = 0

    def __init__(self, pea, window):
        # 主体窗口
        self.window = window
        # 豌豆对象
        self.pea = pea
        # 加载一个僵尸图片
        self.image = pygame.image.load("./material/image/zombie.gif")
        # 改变图片大小
        self.image = pygame.transform.scale(self.image, (70, 70))
        # 获取到僵尸图片的大小和位置
        self.image_rect = self.image.get_rect()
        # 设置僵尸显示的位置
        self.image_rect.top = random.randint(10, self.window.height - 70)
        self.image_rect.left = self.window.width

    # 显示炮弹的方法
    def display(self):
        self.window.screen.blit(self.image, self.image_rect)

    # 移动僵尸
    def move(self):
        # 移动僵尸
        self.image_rect.move_ip(-2, 0)

        # 如果僵尸越界，删除僵尸
        if self.image_rect.left < 0:
            Zombie.zombie_list.remove(self)

        # 如果豌豆和僵尸碰撞，则游戏结束
        if self.image_rect.colliderect(self.pea.image_rect):
            pygame.quit()
            exit()

        # 如果炮弹和僵尸碰撞，则炮弹和僵尸都要消失
        for b in bt.Bullet.bullet_list:
            if self.image_rect.colliderect(b.image_rect):
                bt.Bullet.bullet_list.remove(b)
                self.zombie_list.remove(self)
                break