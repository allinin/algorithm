package Gof.responsibilityChain;

public abstract class Approver {

    String name;
    Approver approver;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver)
    {
        this.approver=approver;
    }

    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
