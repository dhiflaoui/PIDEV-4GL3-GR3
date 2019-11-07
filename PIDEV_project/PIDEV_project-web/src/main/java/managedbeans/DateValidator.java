package managedbeans;


import java.util.Date;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


 
@FacesValidator("dateValidator") 
public class DateValidator  implements Validator {

	public void validate(FacesContext context,
            UIComponent uiComponent, Object o) throws ValidatorException {
UIInput startDateInput = (UIInput) uiComponent.getAttributes().get("startDateatt");
Date startDate = (Date) startDateInput.getValue();
Date endDate = (Date) o;

if (endDate.before(startDate)) {
FacesMessage msg =
       new FacesMessage(FacesMessage.SEVERITY_ERROR,
               "Invalid start/end dates.",
               "Start date cannot be after end date.");
throw new ValidatorException(msg);
} }
	}