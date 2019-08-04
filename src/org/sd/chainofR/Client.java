package org.sd.chainofR;

public class Client {
        public static void main(String[] args) {
    Leader a = new Director("张三");
    Leader b = new Manager("李四");

    Leader c = new GeneralManager("王五");
    //组织责任链对象的关系
    a.setNextLeader(b);
    b.setNextLeader(c);


    //开始请假操作
    LeaveRequest req1 = new LeaveRequest("TOM", 6, "回英国老家探亲！");
    a.handleRequest(req1);

}
}
