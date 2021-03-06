from bin.main import main

if __name__ == '__main__':
    main()

"""
PlayPeaZombie/
|-- bin/
|   |-- __init__.py
|   |-- main.py         程序运行主体程序
|-- config/
|   |-- __init__.py
|   |-- settings.py     程序配置(例如: 游戏背景音乐的加载等)
|-- material            程序素材放置(植物大战僵尸戏素材放置)
|   |-- __init__.py
|   |-- image           程序图片
|   |-- sound           程序音乐
|   |-- ......
|-- src/                程序主体模块存放
|   |-- __init__.py
|   |-- bullet.py       炮弹弹实现代码存放
|   |-- control.py      事件控制实现代码存放
|   |-- pea.py          豌豆实现代码存放
|   |-- zombie.py       僵尸实现代码存放
|   |-- screen.py       主体窗口实现代码存放
|-- manage.py           程序启动文件
|-- README.md           程序使用说明
"""