package org.palladiosimulator.protocom.tech.rmi.repository;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.impl.JField;
import org.palladiosimulator.protocom.lang.java.impl.JMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaConstants;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.PcmCommons;
import org.palladiosimulator.protocom.tech.rmi.PojoComposedStructureClass;

/**
 * Provider for CompositeComponents.
 * 
 * In contrast to other ComposedStructures, the encapsulated components are created by this one.
 * 
 * @author Thomas Zolynski, Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PojoCompositeComponentClass extends PojoComposedStructureClass<CompositeComponent> {
  public PojoCompositeComponentClass(final CompositeComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public Collection<String> interfaces() {
    String _interfaceName = JavaNames.interfaceName(this.pcmEntity);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_interfaceName));
  }
  
  public Collection<? extends IJMethod> constructors() {
    JMethod _jMethod = new JMethod();
    JMethod _withParameters = _jMethod.withParameters("String assemblyContextID");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.assemblyContextID = assemblyContextID;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<AssemblyContext> _assemblyContexts__ComposedStructure = this.pcmEntity.getAssemblyContexts__ComposedStructure();
      for(final AssemblyContext assemblyContext : _assemblyContexts__ComposedStructure) {
        _builder.append("my");
        String _javaName = JavaNames.javaName(assemblyContext);
        _builder.append(_javaName, "");
        _builder.append(" = new ");
        RepositoryComponent _encapsulatedComponent__AssemblyContext = assemblyContext.getEncapsulatedComponent__AssemblyContext();
        String _fqn = JavaNames.fqn(_encapsulatedComponent__AssemblyContext);
        _builder.append(_fqn, "");
        _builder.append("(\"");
        String _id = assemblyContext.getId();
        _builder.append(_id, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("initInnerComponents();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.newLine();
    {
      EList<ProvidedRole> _providedRoles_InterfaceProvidingEntity = this.pcmEntity.getProvidedRoles_InterfaceProvidingEntity();
      final Function1<ProvidedRole,Boolean> _function = new Function1<ProvidedRole,Boolean>() {
        public Boolean apply(final ProvidedRole it) {
          boolean _isInstance = OperationProvidedRole.class.isInstance(it);
          return Boolean.valueOf(_isInstance);
        }
      };
      Iterable<ProvidedRole> _filter = IterableExtensions.<ProvidedRole>filter(_providedRoles_InterfaceProvidingEntity, _function);
      final Function1<ProvidedRole,OperationProvidedRole> _function_1 = new Function1<ProvidedRole,OperationProvidedRole>() {
        public OperationProvidedRole apply(final ProvidedRole it) {
          return ((OperationProvidedRole) it);
        }
      };
      Iterable<OperationProvidedRole> _map = IterableExtensions.<ProvidedRole, OperationProvidedRole>map(_filter, _function_1);
      boolean _hasElements = false;
      for(final OperationProvidedRole role : _map) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("try {", "");
        }
        String _portMemberVar = JavaNames.portMemberVar(role);
        _builder.append(_portMemberVar, "");
        _builder.append(" = new ");
        String _fqnPort = JavaNames.fqnPort(role);
        _builder.append(_fqnPort, "");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        _builder.append("(");
        OperationInterface _providedInterface__OperationProvidedRole = role.getProvidedInterface__OperationProvidedRole();
        String _fqn_1 = JavaNames.fqn(_providedInterface__OperationProvidedRole);
        _builder.append(_fqn_1, "");
        _builder.append(") my");
        ProvidedDelegationConnector _providedDelegationConnector = PcmCommons.getProvidedDelegationConnector(this.pcmEntity, role);
        AssemblyContext _assemblyContext_ProvidedDelegationConnector = _providedDelegationConnector.getAssemblyContext_ProvidedDelegationConnector();
        String _javaName_1 = JavaNames.javaName(_assemblyContext_ProvidedDelegationConnector);
        _builder.append(_javaName_1, "");
        _builder.append(",\t\t\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("this, assemblyContextID);");
        _builder.newLine();
      }
      if (_hasElements) {
        _builder.append("} catch (java.rmi.RemoteException e) {  }", "");
      }
    }
    JMethod _withImplementation = _withParameters.withImplementation(_builder.toString());
    return Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withImplementation));
  }
  
  public Collection<? extends IJField> fields() {
    LinkedList<IJField> _xblockexpression = null;
    {
      final LinkedList<IJField> results = CollectionLiterals.<IJField>newLinkedList();
      Collection<? extends IJField> _fields = super.fields();
      Iterables.<IJField>addAll(results, _fields);
      JField _jField = new JField();
      JField _withName = _jField.withName("myComponentStackFrame");
      String _stackframeType = PcmCommons.stackframeType();
      JField _withType = _withName.withType(_stackframeType);
      JField _jField_1 = new JField();
      JField _withName_1 = _jField_1.withName("myDefaultComponentStackFrame");
      String _stackframeType_1 = PcmCommons.stackframeType();
      JField _withType_1 = _withName_1.withType(_stackframeType_1);
      Iterables.<IJField>addAll(results, Collections.<JField>unmodifiableList(Lists.<JField>newArrayList(_withType, _withType_1)));
      EList<AssemblyContext> _assemblyContexts__ComposedStructure = this.pcmEntity.getAssemblyContexts__ComposedStructure();
      final Function1<AssemblyContext,JField> _function = new Function1<AssemblyContext,JField>() {
        public JField apply(final AssemblyContext it) {
          JField _jField = new JField();
          String _javaName = JavaNames.javaName(it);
          String _plus = ("my" + _javaName);
          JField _withName = _jField.withName(_plus);
          RepositoryComponent _encapsulatedComponent__AssemblyContext = it.getEncapsulatedComponent__AssemblyContext();
          String _fqn = JavaNames.fqn(_encapsulatedComponent__AssemblyContext);
          JField _withType = _withName.withType(_fqn);
          return _withType;
        }
      };
      List<IJField> _map = ListExtensions.<AssemblyContext, IJField>map(_assemblyContexts__ComposedStructure, _function);
      Iterables.<IJField>addAll(results, _map);
      _xblockexpression = (results);
    }
    return _xblockexpression;
  }
  
  public Collection<? extends IJMethod> methods() {
    LinkedList<IJMethod> _xblockexpression = null;
    {
      final LinkedList<IJMethod> results = CollectionLiterals.<IJMethod>newLinkedList();
      Collection<? extends IJMethod> _methods = super.methods();
      Iterables.<IJMethod>addAll(results, _methods);
      JMethod _jMethod = new JMethod();
      JMethod _withName = _jMethod.withName("initInnerComponents");
      JMethod _withVisibilityModifier = _withName.withVisibilityModifier(JavaConstants.VISIBILITY_PRIVATE);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("try {");
      _builder.newLine();
      {
        EList<AssemblyContext> _assemblyContexts__ComposedStructure = this.pcmEntity.getAssemblyContexts__ComposedStructure();
        for(final AssemblyContext assemblyContext : _assemblyContexts__ComposedStructure) {
          _builder.append("\t");
          _builder.append("init");
          String _javaName = JavaNames.javaName(assemblyContext);
          _builder.append(_javaName, "	");
          _builder.append("();");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (java.rmi.RemoteException e) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("e.printStackTrace();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      JMethod _withImplementation = _withVisibilityModifier.withImplementation(_builder.toString());
      Iterables.<IJMethod>addAll(results, Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withImplementation)));
      JMethod _jMethod_1 = new JMethod();
      JMethod _withName_1 = _jMethod_1.withName("setComponentFrame");
      String _stackframeParameterList = PcmCommons.stackframeParameterList();
      JMethod _withParameters = _withName_1.withParameters(_stackframeParameterList);
      JMethod _withImplementation_1 = _withParameters.withImplementation("this.myComponentStackFrame = myComponentStackFrame; this.myDefaultComponentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();");
      Iterables.<IJMethod>addAll(results, Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withImplementation_1)));
      _xblockexpression = (results);
    }
    return _xblockexpression;
  }
}
