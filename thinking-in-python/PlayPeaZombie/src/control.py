"""
事件监听
"""
import pygame
from pygame.locals import *


class Control:

    # 事件监听处理
    def key_control(self, pea):
        for event in pygame.event.get():
            # 事件类型判断
            if event.type == QUIT:
                # 退出游戏
                pygame.quit()
                # 退出系统
                exit()
            # 按下事件类型的监听
            elif event.type == KEYDOWN:
                # 判断具体的键
                if event.key == K_UP:
                    print("向上移动")
                    pea.is_move_up = True
                elif event.key == K_DOWN:
                    print("向下移动")
                    pea.is_move_down = True
                elif event.key == K_SPACE:
                    print("空格事件")
                    pea.is_shout = True
            # 键盘松开事件监听
            elif event.type == KEYUP:
                # 判断具体的键
                if event.key == K_UP:
                    print("向上移动放松")
                    pea.is_move_up = False
                elif event.key == K_DOWN:
                    print("向下移动放松")
                    pea.is_move_down = False
                elif event.key == K_SPACE:
                    print("空格事件放松")
                    pea.is_shout = False
