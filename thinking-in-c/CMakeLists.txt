cmake_minimum_required(VERSION 3.16)
project(thinking-in-c C)

set(CMAKE_C_STANDARD 99)

# 添加源文件
file(GLOB_RECURSE SOURCES "src/*.c")

# 添加可执行文件
add_executable(thinking-in-c ${SOURCES})