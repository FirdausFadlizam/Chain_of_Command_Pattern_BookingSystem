public abstract class BidHandler {
    protected BidHandler successor;

    public void setSuccessor(BidHandler successor){
        this.successor = successor;
    }

    public abstract String bidRequest(double bidPrice, int totalAvailableRoom);

}
