package tn.esprit.spring.dto;



public class BankOffersDto {
	private Long idBankOffer;
	private String nameBankoffer;
	private String descriptionBankOffer;
	private String gracePeriod;
	private int selfFinancing;
	private double maxCredit;
    private int period;
	BankDto bank;
	
	//Getters,Setters,Constructors

	public Long getIdBankOffer() {
		return idBankOffer;
	}

	public void setIdBankOffer(Long idBankOffer) {
		this.idBankOffer = idBankOffer;
	}

	public String getNameBankoffer() {
		return nameBankoffer;
	}

	public void setNameBankoffer(String nameBankoffer) {
		this.nameBankoffer = nameBankoffer;
	}

	public String getDescriptionBankOffer() {
		return descriptionBankOffer;
	}

	public void setDescriptionBankOffer(String descriptionBankOffer) {
		this.descriptionBankOffer = descriptionBankOffer;
	}

	public String getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(String gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public int getSelfFinancing() {
		return selfFinancing;
	}

	public void setSelfFinancing(int selfFinancing) {
		this.selfFinancing = selfFinancing;
	}

	public double getMaxCredit() {
		return maxCredit;
	}

	public void setMaxCredit(double maxCredit) {
		this.maxCredit = maxCredit;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public BankDto getBank() {
		return bank;
	}

	public void setBank(BankDto bank) {
		this.bank = bank;
	}

	public BankOffersDto(Long idBankOffer, String nameBankoffer, String descriptionBankOffer, String gracePeriod,
			int selfFinancing, double maxCredit, int period, BankDto bank) {
		super();
		this.idBankOffer = idBankOffer;
		this.nameBankoffer = nameBankoffer;
		this.descriptionBankOffer = descriptionBankOffer;
		this.gracePeriod = gracePeriod;
		this.selfFinancing = selfFinancing;
		this.maxCredit = maxCredit;
		this.period = period;
		this.bank = bank;
	}

	public BankOffersDto() {
		super();
	}
	
	

}
