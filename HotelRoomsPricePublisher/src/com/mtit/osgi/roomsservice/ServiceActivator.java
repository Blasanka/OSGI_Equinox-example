package com.mtit.osgi.roomsservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.mtit.osgi.roomsservice.usecase.HotelRoomsServiceImpl;
import com.mtit.osgi.roomsservice.usecase.IHotelRoomsService;

public class ServiceActivator implements BundleActivator {
	
	ServiceRegistration<?> serviceRegistor;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("HotelRoomsPricePublisher started");
		IHotelRoomsService hotelService = new HotelRoomsServiceImpl();
		serviceRegistor = context.registerService(IHotelRoomsService.class.getName(), hotelService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("HotelRoomsPricePublisher stopped");
		serviceRegistor.unregister();
	}

}
