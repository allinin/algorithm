package org.sd.composite;

import java.util.ArrayList;
import java.util.List;

public interface AbstractFile {
    void killVirus();
}
class ImageFile implements AbstractFile {
    private String name;

    public ImageFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---图像文件："+name+",进行查杀！");
    }

}
class TextFile implements AbstractFile {
    private String name;

    public TextFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---文本文件："+name+",进行查杀！");
    }
}
class VideoFile implements AbstractFile {
    private String name;

    public VideoFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---视频文件："+name+",进行查杀！");
    }
}
class Folder implements AbstractFile{
    private String name;
    private List<AbstractFile>list=new ArrayList<>();
    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("-----文件夹"+name+"进行杀毒");
        for(AbstractFile file:list)
        {
            file.killVirus();
        }


    }
    public void add(AbstractFile file)
    {
        list.add(file);
    }
    public void remove(AbstractFile file)
    {
        list.remove(file);
    }
    public AbstractFile getChild(int index)
    {
        return list.get(index);
    }
}

