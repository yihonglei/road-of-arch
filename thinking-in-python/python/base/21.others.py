#!/usr/bin/python
# -*- coding: UTF-8 -*-
import os
import sys
import time

# 所有项目
project_names = ['xw_api', 'xw_scheduled', 'xw_manage', 'java.66']
# 项目对应服务器
host_names = {'xw_api': ['newjava4', 'newjava5', 'newjava8', 'newjava9'],
              'xw_scheduled': ['newjava1'],
              'xw_manage': ['newjava5', 'newjava8', 'newjava9'],
              'java.66': ['java.66']
              }

# 获取argv列表的长度
length = len(sys.argv)
if length != 2:
    print(
    "please enter argv", project_names)
    exit()

# 启动时获取项目名
project_name = sys.argv[1]
if project_name not in project_names:
    print(
    "please enter argv", project_names)
    exit()

# 全局变量 主机个数数
host_count = len(host_names[project_name])


# 创建窗口  根据数量拆分
def create_windows(hosts):
    if host_count == 1:  # 一个直接走这里
        split_row()
        login(hosts[0])
        previous_win()
    elif host_count == 2:  # 两个走这俩
        split_row()
        login(hosts[0])
        split_column()
        login(hosts[1])
        next_win()
    elif host_count == 3:  #
        split_row()
        login(hosts[1])
        split_column()
        login(hosts[2])
        previous_win()
        previous_win()
        split_column()
        login(hosts[0])
        previous_win()
    elif host_count == 4:  #
        split_row()
        login(hosts[0])
        split_row()
        login(hosts[2])
        split_column()
        login(hosts[3])
        previous_win()
        previous_win()
        split_column()
        login(hosts[1])
        previous_win()
        previous_win()
    else:
        print
        "暂时没有配置那么多服务器"
        exit()


# 回车键
def enter():
    to_enter = """osascript -e 'tell application "System Events" to key code 52'"""
    os.system(to_enter)


# 前一窗口
def previous_win():
    previous = """osascript -e 'tell application "System Events" to keystroke "[" using command down'"""
    os.system(previous)


# 后一窗口
def next_win():
    next = """osascript -e 'tell application "System Events" to keystroke "]" using command down'"""
    os.system(next)


# 关闭当前窗口
def close_curr_win():
    curr_win = """osascript -e 'tell application "System Events" to keystroke "w" using command down'"""
    os.system(curr_win)


# 多窗口同步
def syn_all_win():
    all_win = """osascript -e 'tell application "System Events" to keystroke "i" using {command down, shift down}'"""
    os.system(all_win)


# 跳转到日志文件夹
def goto_log_file():
    file_name = 'business'
    if project_name == 'xw_scheduled':
        file_name = 'scheduled'

    if project_name == 'xw_manage':
        file_name = 'manager'

    if project_name == 'java.66':
        file_name = '../testlog/new/scheduled'

    bridge = """osascript -e 'tell application "System Events" to keystroke "cd /data/log/%(server)s"'"""
    os.system(bridge % dict(server=file_name))
    enter()


# 拆分行
def split_column():
    sp_column = """osascript -e 'tell application "System Events" to keystroke "d" using command down'"""
    os.system(sp_column)


# 拆分列
def split_row():
    sp_row = """osascript -e 'tell application "System Events" to keystroke "d" using {command down, shift down}'"""
    os.system(sp_row)


# 自动登录主机

def login(host):
    # 登录跳板机
    bridge = """osascript -e 'tell application "System Events" to keystroke "ssh dev"'"""
    os.system(bridge)
    enter()
    time.sleep(0.8)
    # 切换用户 dev
    bridge = """osascript -e 'tell application "System Events" to keystroke "su dev"'"""
    os.system(bridge)
    enter()
    time.sleep(0.3)
    # dev用户密码
    bridge = """osascript -e 'tell application "System Events" to keystroke "qwe123!@#"'"""
    os.system(bridge)
    enter()
    # 登录主机
    bridge = """osascript -e 'tell application "System Events" to keystroke "ssh %(server)s"'"""
    os.system(bridge % dict(server=host))
    enter()


def entering(content):
    count = 0
    while count < host_count:
        next_win()
        to_enter = """osascript -e 'tell application "System Events" to keystroke "%(argv)s"'"""
        os.system(to_enter % dict(argv=content))
        enter()
        count = count + 1


# new_windows = True
exit_count = 0
if __name__ == '__main__':
    # 创建窗口
    create_windows(host_names[project_name])
    # 多窗口同步
    syn_all_win()
    # 转到日志文件
    goto_log_file()
    # 关闭多窗口同步
    # syn_all_win()
    # 关闭当前窗口
    close_curr_win()
