"""
豌豆对象
"""
import pygame

# 解决循环依赖导包方式之一
import src.bullet as bt
import src.zombie as ze


# 豌豆对象
class Pea:
    """
    初始化豌豆属性
    """
    def __init__(self, window):
        # 主体窗口
        self.window = window
        # 加载一个豌豆图片
        self.image = pygame.image.load("./material/image/pea.gif")
        # 获取到豌豆图片的大小和位置
        self.image_rect = self.image.get_rect()
        # 设置豌豆显示的位置
        self.image_rect.top = 285
        self.image_rect.left = 30
        # 判断豌豆是否向上移动
        self.is_move_up = False
        # 判断豌豆是否向下移动
        self.is_move_down = False
        # 判断豌豆是否射炮弹
        self.is_shout = False

    """
    豌豆显示
    """
    def display(self):
        # 设置豌豆背景图片
        self.window.screen.blit(self.image, self.image_rect)

    """
    豌豆向上移动
    """
    def move_up(self):
        # 如果越界，则不能移动，否则，可以移动
        if self.image_rect.top > 30:
            self.image_rect.move_ip(0, -10)

        # 如果向上移动的时候，僵尸和豌豆碰撞，游戏结束
        for z in ze.Zombie.zombie_list:
            if self.image_rect.colliderect(z.image_rect):
                pygame.quit()
                exit()

    """
    豌豆向下移动
    """
    def move_down(self):
        # 如果越界，则不能移动，否则可以移动
        if self.image_rect.bottom < 600:
            self.image_rect.move_ip(0, 10)

        # 如果向下移动的时候，僵尸和豌豆碰撞，游戏结束
        for z in ze.Zombie.zombie_list:
            if self.image_rect.colliderect(z.image_rect):
                pygame.quit()
                exit()

    """
    炮弹发射
    """
    def bullet_shout(self, screen):
        # 创建一个炮弹
        bullet = bt.Bullet(self, screen)
        bt.Bullet.bullet_list.append(bullet)