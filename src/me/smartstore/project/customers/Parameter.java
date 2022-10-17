package me.smartstore.project.customers;

public class Parameter {
    //VIP VVIP기준을 판단해주는 기준을 갖는 클래스
    private static Parameter parameter = new Parameter();
    //판단 기준은 유일하므로 싱글톤으로 생성

    private int VIPMinPurchaseCount = 10;
    private int VIPMinTotalPay = 10000;

    private int VVIPMinPurchaseCount = 20;
    private int VVIPMinTotalPay = 20000;
    //VIP VVIP가 되기위한 디폴트 기준
    //배열이나 클래스로 또 묶어서 정리할까 했는데 2개씩 밖에 안되므로 그냥 이렇게 만듦
    //만약 VIP VVIP VVVIP VVVVIP 이런식으로 많았으면
    //int[] minPurchaseCount 해서 enum 순서대로 넣는방식을 썼을듯

    private Parameter() {
    }

    public static Parameter getInstance() {
        if (parameter == null)
            parameter = new Parameter();
        return parameter;
    }


    public int getVIPMinPurchaseCount() {
        return VIPMinPurchaseCount;
    }

    public void setVIPMinPurchaseCount(int VIPMinPurchaseCount) {
        this.VIPMinPurchaseCount = VIPMinPurchaseCount;
    }

    public int getVIPMinTotalPay() {
        return VIPMinTotalPay;
    }

    public void setVIPMinTotalPay(int VIPMinTotalPay) {
        this.VIPMinTotalPay = VIPMinTotalPay;
    }

    public int getVVIPMinPurchaseCount() {
        return VVIPMinPurchaseCount;
    }

    public void setVVIPMinPurchaseCount(int VVIPMinPurchaseCount) {
        this.VVIPMinPurchaseCount = VVIPMinPurchaseCount;
    }

    public int getVVIPMinTotalPay() {
        return VVIPMinTotalPay;
    }

    public void setVVIPMinTotalPay(int VVIPMinTotalPay) {
        this.VVIPMinTotalPay = VVIPMinTotalPay;
    }
}
