package 重温设计模式.行为模式.观察者模式.示例;

import java.io.File;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/8 16:35
 */
public class Editor {

    public EventManager managers;
    private File file;

    public Editor(){
        this.managers = new EventManager("open","close");
    }

    public void openFile(String filePath){
        this.file = new File(filePath);
        managers.notify("open",file);
    }

    public void saveFile() throws Exception{
        if(this.file != null){
            managers.notify("close",file);
        }else{
            throw new Exception("Please open a file first..");

        }
    }


}
