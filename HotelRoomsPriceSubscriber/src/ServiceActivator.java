

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.mtit.osgi.roomsservice.usecase.HotelRoomsServiceImpl;
import com.mtit.osgi.roomsservice.usecase.IHotelRoomsService;

public class ServiceActivator implements BundleActivator {

	ServiceReference<?> serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("HotelRoomsPriceSubscriber started");
		serviceReference = context.getServiceReference(IHotelRoomsService.class.getName());
		IHotelRoomsService hotelRoomsService = (HotelRoomsServiceImpl) context.getService(serviceReference);
		hotelRoomsService.getRoomTypeFare();
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("HotelRoomsPriceSubscriber stopped");
		context.ungetService(serviceReference);
	}

}
