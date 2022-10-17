package me.smartstore.project.customers;

public class Group {
    private GroupType groupType;

    public Parameter parameter = Parameter.getInstance();

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(int purchaseCount, int totalPay) {
        //purchaseCount와 totalPay를 받아 VIP VVIP기준과 비교해서 groupType을 설정해준다
        if (purchaseCount < parameter.getVIPMinPurchaseCount() || totalPay < parameter.getVIPMinTotalPay())
            //VIP 기준보다 하나라도 모자라면 GENERAL
            this.groupType = GroupType.GENERAL;

        else if (purchaseCount >= parameter.getVVIPMinPurchaseCount() && totalPay >= parameter.getVVIPMinTotalPay())
            //VVIP 기준을 전부 만족하면 VVIP
            this.groupType = GroupType.VVIP;

        else
            //둘다 아니라면 VIP
            this.groupType = GroupType.VIP;
    }

}
