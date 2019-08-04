package org.sd.chainofR;

public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }
    //设置责任链上的后即对象
    public void setNextLeader(Leader nextLeader)
    {
        this.nextLeader=nextLeader;
    }

    public abstract void handleRequest(LeaveRequest request);

}
