package pe.com.bootcamp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @AllArgsConstructor @Getter @Setter
@Entity @Table
public class Contribution {
	@Id	
	private String affiliateCode;
	@Column
	private Double cumulativeContributions;
	@Column
	private Double withdrawalsAndAccruedFees;
	@Column
	private Double accumulatedProfitability;
	@Column
	private Double accumulatedFund;	
	
	public Contribution() {}
}
