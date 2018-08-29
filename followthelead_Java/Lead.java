package com.example.grant.followthelead;

public class Lead {
    private String _phoneNumber;
    private String address;
    private String _name;
    private String email;
    private String vehicleMake, vehicleModel, vehicleYear;
    private int _dlNum;
    private String spouseName, spouseDL;
    private String currentInsuranceProvider;
    private int liabilityLimit, collisionDeductible, comprehensiveDeductible;
    private String carrier;
    private boolean rent, own, homeInsuredByCarrier;
    private String homeInsuranceCarrier;
    private float homeCoverageAmount;
    private String additionalInfo;
    private Event associatedEvent;

    public Lead() {
    }

    public boolean verifyRequiredInput() {
        //verify all required fields are populated
        return true;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public int get_dlNum() {
        return _dlNum;
    }

    public void set_dlNum(int _dlNum) {
        this._dlNum = _dlNum;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseDL() {
        return spouseDL;
    }

    public void setSpouseDL(String spouseDL) {
        this.spouseDL = spouseDL;
    }

    public String getCurrentInsuranceProvider() {
        return currentInsuranceProvider;
    }

    public void setCurrentInsuranceProvider(String currentInsuranceProvider) {
        this.currentInsuranceProvider = currentInsuranceProvider;
    }

    public int getLiabilityLimit() {
        return liabilityLimit;
    }

    public void setLiabilityLimit(int liabilityLimit) {
        this.liabilityLimit = liabilityLimit;
    }

    public int getCollisionDeductible() {
        return collisionDeductible;
    }

    public void setCollisionDeductible(int collisionDeductible) {
        this.collisionDeductible = collisionDeductible;
    }

    public int getComprehensiveDeductible() {
        return comprehensiveDeductible;
    }

    public void setComprehensiveDeductible(int comprehensiveDeductible) {
        this.comprehensiveDeductible = comprehensiveDeductible;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public boolean isOwn() {
        return own;
    }

    public void setOwn(boolean own) {
        this.own = own;
    }

    public boolean isHomeInsuredByCarrier() {
        return homeInsuredByCarrier;
    }

    public void setHomeInsuredByCarrier(boolean homeInsuredByCarrier) {
        this.homeInsuredByCarrier = homeInsuredByCarrier;
    }

    public String getHomeInsuranceCarrier() {
        return homeInsuranceCarrier;
    }

    public void setHomeInsuranceCarrier(String homeInsuranceCarrier) {
        this.homeInsuranceCarrier = homeInsuranceCarrier;
    }

    public float getHomeCoverageAmount() {
        return homeCoverageAmount;
    }

    public void setHomeCoverageAmount(float homeCoverageAmount) {
        this.homeCoverageAmount = homeCoverageAmount;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Event getAssociatedEvent() {
        return associatedEvent;
    }

    public void setAssociatedEvent(Event associatedEvent) {
        this.associatedEvent = associatedEvent;
    }
}
