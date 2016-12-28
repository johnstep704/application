package johnstep.vehicle;

public class VehicleDesc {
	
	public VehicleDesc(){
		super();
	}
	VehicleDesc(int i, String desc, String license, String vNr, String sNr){
		this.id =i;
		this.description = desc;
		this.licensePlate = license;
		this.vinNr = vNr;
		this.stsNr = sNr;
		
	}
	
	private int id;
	private String description;
	private String licensePlate;
	private String vinNr;
	private String stsNr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getVinNr() {
		return vinNr;
	}
	public void setVinNr(String vinNr) {
		this.vinNr = vinNr;
	}
	public String getStsNr() {
		return stsNr;
	}
	public void setStsNr(String stsNr) {
		this.stsNr = stsNr;
	}

}
