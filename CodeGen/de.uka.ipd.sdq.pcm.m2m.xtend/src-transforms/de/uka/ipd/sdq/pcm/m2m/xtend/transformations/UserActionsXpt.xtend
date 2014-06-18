package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction
import de.uka.ipd.sdq.pcm.usagemodel.Start
import de.uka.ipd.sdq.pcm.usagemodel.Stop
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import de.uka.ipd.sdq.pcm.usagemodel.Loop
import de.uka.ipd.sdq.pcm.usagemodel.Branch
import de.uka.ipd.sdq.pcm.usagemodel.Delay
import com.google.inject.Inject

abstract class UserActionsXpt {
	@Inject extension CallsXpt
	@Inject extension JavaNamesExt

	def CharSequence userAction(AbstractUserAction aua) 
	
	def CharSequence userAction(Start start) 
	def CharSequence userAction(Stop stop) 
	def CharSequence userAction(EntryLevelSystemCall elsc) '''
				// Set the priority for �elsc.entityName�
				thread.setPriority(�elsc.priority�);
		�elsc.operationSignature__EntryLevelSystemCall.call(
			elsc,
			elsc.providedRole_EntryLevelSystemCall.portMemberVar+".",
			elsc.inputParameterUsages_EntryLevelSystemCall,
			{})�
	'''
	
	def CharSequence userAction(Loop loop)
	def CharSequence userAction(Branch branch) 
	def CharSequence userAction(Delay delay)
}