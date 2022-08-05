-- drop table public.person
create table if not exists public.person
(
    type_of_identity_document varchar(5) not null,
    identification_number varchar(8) not null,        
    first_name varchar(125),
    last_name varchar(125),
    date_of_birth date,
    marital_status varchar(30),
    nationatity varchar(15),
    ubigeo varchar(15)    
);

alter table Person
add constraint person_pkey primary key(identification_number, type_of_identity_document);

-- drop table public.Affiliate
create table if not exists public.Affiliate(
    type_of_identity_document varchar(5) not null,
	identification_number varchar(8) not null,     
    code varchar(15) not null,	    
	origen varchar(30),
	type_commission varchar(30),	
	currentAFP varchar(30),	
	date_of_last_contribution timestamp,
	date_of_consultation timestamp,
	date_of_entry_to_theSPP timestamp,	
	type_of_worker varchar(11), -- // Dependent / Independent	
	status varchar(20),
	date_of_affiliation_to_currentAFP timestamp
);

alter table Affiliate
add constraint pkAffiliate primary key(code);

alter table Affiliate
add constraint fkAffiliatePerson foreign key(type_of_identity_document, identification_number) references Person(type_of_identity_document, identification_number);

alter table Affiliate
drop constraint fkAffiliatePerson;

create table Contribution(
    affiliate_code varchar(15) not null,	
	cumulative_contributions decimal(18,5),	
	withdrawals_and_accruedFees decimal(18,5),	
	accumulated_profitability decimal(18,5),	
	accumulated_fund decimal(18,5)
);

alter table Contribution
add constraint pkContribution primary key(affiliate_code);

alter table Affiliate
add constraint fkAffiliateContribution foreign key(code) references Contribution(affiliate_code);

alter table Affiliate
drop constraint fkAffiliateContribution;

select * from Person;
truncate Person;
select * from Affiliate;
select * from Contribution;