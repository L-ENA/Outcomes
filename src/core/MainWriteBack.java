package core;
import java.io.File;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import trialAndOutcome.TrialObject;


//test123

public class MainWriteBack {
	

	
	public static void main(String[] args)  throws Exception{
		
		JOptionPane.showMessageDialog(null, "Please select one or more ReviewManager5 (.rm5) files in the next step.\nOutcomes will be appended to the 'characteristics of included studies' table of each included study.\nFirst, dichotomous outcomes are displayed.\nSecondly, the continuous ones. Other outcome types follow.");
		
		Database d = new Database();
		d.makeList();//in Database class a list of trials in this review will be created
		
		if (d.reviewName == "") {//if reviewName is empty it indicates that only the default constructor for trial objects was called in the database class. Therefore, there are no trials included in the review that was analysed.
			System.out.println("No trials included");
		} else {
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(
						//this makes it possible to marshal instances of these classes to XML
						Database.class,
						
						references.JournalReferenceObject.class,
						references.BookReferenceObject.class,
						references.BookSectionReferenceObject.class,
						references.OtherReferenceObject.class,
						references.ConferenceReferenceObject.class,
						references.CorrespondenceReferenceObject.class,
						references.CochraneProtocolReferenceObject.class,
						references.CochraneReviewReferenceObject.class,
						references.SoftwareReferenceObject.class,
						references.UnpublishedReferenceObject.class,
						
						trialAndOutcome.ContinuousOutcomeObject.class,
						trialAndOutcome.DichotomousOutcomeObject.class,
						trialAndOutcome.GenericInverseOutcomeObject.class,
						trialAndOutcome.OEandVarianceOutcomeObject.class,
						trialAndOutcome.OtherOutcomeObject.class,
						trialAndOutcome.OutcomeObject.class,
						trialAndOutcome.Interventions.class,
						trialAndOutcome.ProbablyIntervention.class,
						trialAndOutcome.UnlikelyIntervention.class,
						trialAndOutcome.UnclearIntervention.class,
						trialAndOutcome.OutcomeCharTable.class,
						trialAndOutcome.UnusedOutcome.class,
						trialAndOutcome.UsedOutcome.class,
						
						identifiers.OtherIdentifierObject.class,
						identifiers.ClinTrialGovObject.class,
						identifiers.DoiObject.class,
						identifiers.IsrctnObject.class,
						identifiers.IdentifierObject.class, 
						
						identifiers.MedlineObject.class,
						identifiers.PubMedObject.class,
						identifiers.CentralObject.class,
						identifiers.EmbaseObject.class
						
						
						
						
						
						
						
						);
				//Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				//jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				
				
				
				//String path = "C:\\Users\\msals12\\Desktop\\Thesis\\XMLs\\2206.xml";
				//jaxbMarshaller.marshal(d, new File(path));	//puts database into a xml file that is saved according to path String
				
				System.out.println("File created successfully");
				//System.out.println(TrialObject.counter);
				JOptionPane.showMessageDialog(null, "All your files were stored in the source folder, according to your preferred option.");
				System.exit(0);
				
				
			} catch (JAXBException e) {
				
				e.printStackTrace();
			}
		}
		
	
		

	}
	
	
	
	
}

