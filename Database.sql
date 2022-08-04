create table Person(
    typeOfIdentityDocument varchar(5) null,
	identificationNumber varchar(8) null,    
	firstName varchar(125),
	lastName varchar(125),
	dateOfBirth Date,
	maritalStatus varchar(30),
	ubigeo varchar(15),
	nationatity varchar(15)	
	-- affiliateCode varchar(15)
);

alter table Person
add constraint pkPerson primary key(typeOfIdentityDocument,identificationNumber);

create table Affiliate(
    typeOfIdentityDocument varchar(2) not null,
	identificationNumber varchar(8) not null,     
    code varchar(15) not null,	    
	origen varchar(30),
	typeCommission varchar(30),	
	currentAFP varchar(30),	
	dateOfLastContribution timestamp,
	dateOfConsultation timestamp,
	dateOfEntryToTheSPP timestamp,	
	typeOfWorker varchar(11), -- // Dependent / Independent	
	status varchar(20),
	dateOfAffiliationToCurrentAFP timestamp
);

alter table Affiliate
add constraint pkAffiliate primary key(code);

alter table Affiliate
add constraint fkAffiliatePerson foreign key(typeOfIdentityDocument, identificationNumber) references Person(typeOfIdentityDocument, identificationNumber);

alter table Affiliate
drop constraint fkAffiliatePerson;

create table Contribution(
    affiliateCode varchar(15) not null,	
	cumulativeContributions decimal(18,5),	
	withdrawalsAndAccruedFees decimal(18,5),	
	accumulatedProfitability decimal(18,5),	
	accumulatedFund decimal(18,5)
);

alter table Contribution
add constraint pkContribution primary key(affiliateCode);

alter table Affiliate
add constraint fkAffiliateContribution foreign key(code) references Contribution(affiliateCode);

alter table Affiliate
drop constraint fkAffiliateContribution;

select * from Person;
select * from Affiliate;
select * from Contribution;