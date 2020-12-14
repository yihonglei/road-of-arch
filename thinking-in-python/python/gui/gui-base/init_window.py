from tkinter import *


class MY_GUI:
    def __init__(self, init_window):
        self.init_window = init_window

    def set_window(self):
        pass


def gui_start():
    init_window = Tk()

    myGui = MY_GUI(init_window)

    myGui.set_window()

    init_window.mainloop()


gui_start()
