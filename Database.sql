create table if not exists public.person
(
    type_of_identity_document varchar(5) NOT NULL,
    identification_number varchar(8) NOT NULL,    
    date_of_birth date,
    first_name varchar(125),
    last_name varchar(125),
    marital_status varchar(30),
    nationatity varchar(15),
    ubigeo varchar(15)    
);

alter table Person
add constraint person_pkey primary key(identification_number, type_of_identity_document);

create table Affiliate(
    typeOfIdentityDocument varchar(5) not null,
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
truncate Person;
select * from Affiliate;
select * from Contribution;