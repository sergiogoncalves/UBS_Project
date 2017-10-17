package com.ubs.domainobject;



public interface Valor extends Comparable<Valor> {
	  
	 int getId();

	  void setId(final int id);

	  String getCurrency();

	  void setCurrency(final String currency);

	  double getUnit();

	  void setUnit(final double price);

	  @Override
	  default int compareTo(Valor valor) {
		  
	    if (this.getUnit() == valor.getUnit()) {
	      
	    	return 0;
	    	
	    } else if (this.getUnit() > valor.getUnit()) {
	    	
	      return 1;
	      
	    } else {
	    	
	      return -1;
	      
	    }
	  }

}
