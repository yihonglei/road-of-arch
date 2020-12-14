"""
炮弹对象
"""
import pygame

# 解决循环依赖导包方式之一
import src.zombie as ze


# 炮弹对象
class Bullet:
    # 所有的炮弹信息
    bullet_list = []

    # 炮弹创建间隔时间
    interval = 0

    """
    初始化炮弹属性
    """
    def __init__(self, pea, window):
        # 主体窗口
        self.window = window
        self.image = pygame.image.load("./material/image/bullet.gif")
        self.image_rect = self.image.get_rect()
        self.image_rect.top = pea.image_rect.top
        self.image_rect.left = pea.image_rect.right

    """
    炮弹显示
    """
    def display(self):
        # 设置炮弹背景图片
        self.window.screen.blit(self.image, self.image_rect)

    """
    炮弹移动
    """
    def move(self):
        # 移动炮弹
        self.image_rect.move_ip(8, 0)

        # 如果炮弹越界，删除炮弹
        if self.image_rect.right > self.window.width - 20:
            Bullet.bullet_list.remove(self)

        # 如果僵尸和炮弹碰撞，则僵尸和炮弹删除
        for z in ze.Zombie.zombie_list:
            if self.image_rect.colliderect(z.image_rect):
                ze.Zombie.zombie_list.remove(z)
                Bullet.bullet_list.remove(self)
                break