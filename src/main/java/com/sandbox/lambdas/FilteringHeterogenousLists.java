package com.sandbox.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class FilteringHeterogenousLists {
	public static void main(String[] args) {
		// Make the collections
		final List<AddressData> addressDataList = new ArrayList<AddressData>();
		final List<FundingSource> fundingSourceList = new ArrayList<FundingSource>();

		// Fill in the dummy data
		AddressData addressData1 = new AddressData();
		addressData1.setId("one");
		addressData1.setLine1("line1");
		addressData1.setLine2("line2");
		addressData1.setState("California");
		addressData1.setCity("Sacramento");
		addressData1.setCountry("US");
		addressData1.setZip("291093");

		AddressData addressData2 = new AddressData();
		addressData2.setId("two");
		addressData2.setLine1("line1");
		addressData2.setLine2("line2");
		addressData2.setState("California");
		addressData2.setCity("Sacramento");
		addressData2.setCountry("US");
		addressData2.setZip("291093");

		AddressData addressData3 = new AddressData();
		addressData3.setId("three");
		addressData3.setLine1("line1");
		addressData3.setLine2("line2");
		addressData3.setState("California");
		addressData3.setCity("Sacramento");
		addressData3.setCountry("US");
		addressData3.setZip("291093");

		AddressData addressData4 = new AddressData();
		addressData4.setId("four");
		addressData4.setLine1("line1");
		addressData4.setLine2("line2");
		addressData4.setState("California");
		addressData4.setCity("Sacramento");
		addressData4.setCountry("US");
		addressData4.setZip("291093");

		AddressData addressData5 = new AddressData();
		addressData5.setId("five");
		addressData5.setLine1("line1");
		addressData5.setLine2("line2");
		addressData5.setState("California");
		addressData5.setCity("Sacramento");
		addressData5.setCountry("US");
		addressData5.setZip("291093");

		addressDataList.add(addressData1);
		addressDataList.add(addressData2);
		addressDataList.add(addressData3);
		addressDataList.add(addressData4);
		addressDataList.add(addressData5);

		FundingSource fundingSource1 = new FundingSource();
		fundingSource1.setAddressId("ONE");
		fundingSource1.setName("one");

		FundingSource fundingSource2 = new FundingSource();
		fundingSource2.setAddressId("TWO");
		fundingSource2.setName("two");

		fundingSourceList.add(fundingSource1);
		fundingSourceList.add(fundingSource2);

		List<AddressData> unmatchingAddressData = addressDataList
				.stream().filter(ad -> (fundingSourceList.stream()
						.filter(fs -> fs.getAddressId().equalsIgnoreCase(ad.getId())).count()) < 1)
				.collect(Collectors.toList());

		List<AddressData> matchingAddressData = addressDataList
				.stream().filter(ad -> (fundingSourceList.stream()
						.filter(fs -> fs.getAddressId().equalsIgnoreCase(ad.getId())).count()) > 0)
				.collect(Collectors.toList());

		matchingAddressData.forEach(ad -> ad.setConfirmed(true));

		List<AddressData> confirmedAndUnconfirmedAddressData = Stream
				.concat(matchingAddressData.stream(), unmatchingAddressData.stream()).collect(Collectors.toList());
		
		confirmedAndUnconfirmedAddressData.forEach(System.out::println);

	}
}

class AddressData {

	private String id;

	private String line1;

	private String line2;

	private String state;

	private String city;

	private String country;

	private String zip;

	private boolean isConfirmed;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isConfirmed ? 1231 : 1237);
		result = prime * result + ((line1 == null) ? 0 : line1.hashCode());
		result = prime * result + ((line2 == null) ? 0 : line2.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressData other = (AddressData) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isConfirmed != other.isConfirmed)
			return false;
		if (line1 == null) {
			if (other.line1 != null)
				return false;
		} else if (!line1.equals(other.line1))
			return false;
		if (line2 == null) {
			if (other.line2 != null)
				return false;
		} else if (!line2.equals(other.line2))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressData [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", state=" + state + ", city=" + city
				+ ", country=" + country + ", zip=" + zip + ", isConfirmed=" + isConfirmed + "]";
	}
}

class FundingSource {

	private String addressId;

	private String name;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FundingSource other = (FundingSource) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FundingSource [addressId=" + addressId + ", name=" + name + "]";
	}

}
