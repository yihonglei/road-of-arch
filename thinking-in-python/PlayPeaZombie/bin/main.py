"""
植物大战僵尸，程序运行主体。

主要功能：
1、主体窗口显示，以及背景音乐；
2、豌豆显示，以及上下移动；
3、炮弹显示，以及移动；
4、僵尸显示，以及移动；
5、炮弹碰到僵尸或僵尸碰到炮弹，二者均从页面上消失；
6、当僵尸碰到豌豆时，游戏结束；
"""

from config.settings import *
from src.screen import Screen
from src.pea import Pea
from src.bullet import Bullet
from src.zombie import Zombie
from src.control import Control


def main():
    # 播放背景音乐，接收该参数，-1表示无限循环(默认循环播放一次)
    pygame.mixer.music.play(-1)
    # 创建主体窗口对象
    window = Screen()
    # 创建豌豆对象
    pea = Pea(window)
    # 创建一个时钟，优化运行速度的效果
    clock = pygame.time.Clock()

    while True:
        """
        1、设置游戏的主体窗口
        """
        # 填充背景色为黑色，因为豌豆在拖动时会留下拖动痕迹
        window.screen.fill((0, 0, 0))
        # 设置窗体的背景图片
        window.screen.blit(window.scale_background_image, window.scale_background_image_rect)

        """
        2、显示豌豆
        """
        # 显示豌豆
        pea.display()

        """
        3、事件监听处理，豌豆移动
        """
        # 创建事件对象
        control = Control()
        # 调用事件处理
        control.key_control(pea)

        # 豌豆上下移动
        if pea.is_move_up:
            pea.move_up()
        if pea.is_move_down:
            pea.move_down()

        """
        4、显示炮弹
        """
        # 每隔一段时间创建炮弹
        Bullet.interval += 1
        if pea.is_shout and Bullet.interval >= 15:
            Bullet.interval = 0
            pea.bullet_shout(window)

        for bullet in Bullet.bullet_list:
            # 炮弹显示
            bullet.display()
            # 炮弹移动
            bullet.move()

        """
        5、显示僵尸
        """
        # 每隔一段时间创建僵尸
        Zombie.interval += 1
        if Zombie.interval >= 15:
            Zombie.interval = 0
            Zombie.zombie_list.append(Zombie(pea, window))

        # 显示所有的僵尸
        for zombie in Zombie.zombie_list:
            # 僵尸显示
            zombie.display()
            # 僵尸移动
            zombie.move()

        # 更新图片
        pygame.display.update()
        # 帧频率
        clock.tick(60)