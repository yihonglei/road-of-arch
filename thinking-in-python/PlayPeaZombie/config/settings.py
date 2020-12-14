"""
游戏背景音乐初始化;
"""

import pygame

# 游戏初始化
pygame.init()
# 混音器初始化
pygame.mixer.init()
# 载入游戏背景音乐
pygame.mixer.music.load("./material/sound/background.mp3")
pygame.mixer.music.set_volume(0.2)
