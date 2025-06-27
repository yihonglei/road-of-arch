cmake_minimum_required(VERSION 3.16)
project(thinking-in-cpp)

set(CMAKE_CXX_STANDARD 14)

# 添加源文件
file(GLOB_RECURSE SOURCES "src/*.cpp")

# 添加可执行文件
add_executable(thinking-in-cpp ${SOURCES})