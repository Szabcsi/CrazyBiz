package com.example.crazybiz;

import java.text.DateFormat;
import java.util.Date;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class BoughtPanel extends VerticalLayout implements Property.ValueChangeListener{

	private TextField price;
	private PopupDateField date;
	private TextField sellerName;
	private TextField sellerPhone;
	private TextField sellerEmail;
	private TextField sellerCountry;
	private TextField sellerCity;
		
	public BoughtPanel() {
		price = new TextField("Price");
		date = new PopupDateField();
        date.setInputPrompt("Start date");
        date.setResolution(PopupDateField.RESOLUTION_DAY);
        date.addListener(this);
        date.setImmediate(true);
        
        sellerName = new TextField("Name");
        sellerPhone = new TextField("Phone");
        sellerEmail = new TextField("Email");
        sellerCountry = new TextField("Country");
        sellerCity = new TextField("City");
        
        
        addComponent(price);
        addComponent(date);
        addComponent(sellerName);
        addComponent(sellerPhone);
        addComponent(sellerEmail);
        addComponent(sellerCountry);
        addComponent(sellerCity);
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
        Object value = event.getProperty().getValue();
        if (value == null || !(value instanceof Date)) {
            getWindow().showNotification("Invalid date entered");
        } else {
            String dateOut = dateFormatter.format(value);
        }
	}
}