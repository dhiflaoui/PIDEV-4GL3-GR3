package managedbeans;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value = "loginValidator")
public class EmptyFieldValidate implements Validator {


    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       
        
        if(value!=null){
           if(value.toString().trim().equals("")){
               FacesMessage message=new FacesMessage(component.getAttributes().get("label")+" is empty");
               message.setSeverity(FacesMessage.SEVERITY_WARN);
               throw new ValidatorException(message);
           }
       }
    }
    
	
	
}
