package org.palladiosimulator.protocom.traverse.framework.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.palladiosimulator.protocom.traverse.framework.PcmRepresentative;
import org.palladiosimulator.protocom.traverse.framework.repository.XBasicComponent;
import org.palladiosimulator.protocom.traverse.framework.repository.XCollectionDataType;
import org.palladiosimulator.protocom.traverse.framework.repository.XCompositeComponent;
import org.palladiosimulator.protocom.traverse.framework.repository.XCompositeDataType;
import org.palladiosimulator.protocom.traverse.framework.repository.XEventGroup;
import org.palladiosimulator.protocom.traverse.framework.repository.XInfrastructureInterface;
import org.palladiosimulator.protocom.traverse.framework.repository.XOperationInterface;

/**
 * Traversing Repository. Child elements are:
 * <ul>
 * 	<li>Basic Component,
 * 	<li>Composite Component,
 * 	<li>Infrastructure Interface,
 * 	<li>Operation Interface,
 * 	<li>Event Groups,
 *  <li>Data Types.
 * </ul>
 * 
 * @author Thomas Zolynski, Sebastian Lehrig
 */
@SuppressWarnings("all")
public class XRepository extends PcmRepresentative<Repository> {
  public void traverse() {
    EList<Interface> _interfaces__Repository = this.entity.getInterfaces__Repository();
    final Procedure1<Interface> _function = new Procedure1<Interface>() {
      public void apply(final Interface it) {
        XRepository.this.createInterface(it);
      }
    };
    IterableExtensions.<Interface>forEach(_interfaces__Repository, _function);
    EList<RepositoryComponent> _components__Repository = this.entity.getComponents__Repository();
    final Procedure1<RepositoryComponent> _function_1 = new Procedure1<RepositoryComponent>() {
      public void apply(final RepositoryComponent it) {
        XRepository.this.createComponent(it);
      }
    };
    IterableExtensions.<RepositoryComponent>forEach(_components__Repository, _function_1);
    EList<DataType> _dataTypes__Repository = this.entity.getDataTypes__Repository();
    final Procedure1<DataType> _function_2 = new Procedure1<DataType>() {
      public void apply(final DataType it) {
        XRepository.this.createDataType(it);
      }
    };
    IterableExtensions.<DataType>forEach(_dataTypes__Repository, _function_2);
  }
  
  /**
   * Traverse through Composite Components.
   */
  protected void _createComponent(final CompositeComponent componentEntity) {
    XCompositeComponent _instance = this.injector.<XCompositeComponent>getInstance(XCompositeComponent.class);
    PcmRepresentative<CompositeComponent> _setEntity = _instance.setEntity(componentEntity);
    _setEntity.transform();
  }
  
  /**
   * Traverse through Basic Components.
   */
  protected void _createComponent(final BasicComponent componentEntity) {
    XBasicComponent _instance = this.injector.<XBasicComponent>getInstance(XBasicComponent.class);
    PcmRepresentative<BasicComponent> _setEntity = _instance.setEntity(componentEntity);
    _setEntity.transform();
  }
  
  /**
   * Fallback for component traversing.
   */
  protected void _createComponent(final Entity componentEntity) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Unsupported component type.");
    throw _unsupportedOperationException;
  }
  
  /**
   * Traverse through Infrastructure Interfaces.
   */
  protected void _createInterface(final InfrastructureInterface interfaceEntity) {
    XInfrastructureInterface _instance = this.injector.<XInfrastructureInterface>getInstance(XInfrastructureInterface.class);
    PcmRepresentative<InfrastructureInterface> _setEntity = _instance.setEntity(interfaceEntity);
    _setEntity.transform();
  }
  
  /**
   * Traverse through Operation Interfaces.
   */
  protected void _createInterface(final OperationInterface interfaceEntity) {
    XOperationInterface _instance = this.injector.<XOperationInterface>getInstance(XOperationInterface.class);
    PcmRepresentative<OperationInterface> _setEntity = _instance.setEntity(interfaceEntity);
    _setEntity.transform();
  }
  
  /**
   * Traverse through Event Groups.
   */
  protected void _createInterface(final EventGroup interfaceEntity) {
    XEventGroup _instance = this.injector.<XEventGroup>getInstance(XEventGroup.class);
    PcmRepresentative<EventGroup> _setEntity = _instance.setEntity(interfaceEntity);
    _setEntity.transform();
  }
  
  /**
   * Traverse through Data Types.
   */
  protected void _createDataType(final DataType typeEntity) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Unsupported data type.");
    throw _unsupportedOperationException;
  }
  
  /**
   * Traverse through Primitive Data Types.
   */
  protected void _createDataType(final PrimitiveDataType typeEntity) {
    return;
  }
  
  /**
   * Traverse through Composite Data Types.
   */
  protected void _createDataType(final CompositeDataType typeEntity) {
    XCompositeDataType _instance = this.injector.<XCompositeDataType>getInstance(XCompositeDataType.class);
    PcmRepresentative<CompositeDataType> _setEntity = _instance.setEntity(typeEntity);
    _setEntity.transform();
  }
  
  /**
   * Traverse through Collection Data Types.
   */
  protected void _createDataType(final CollectionDataType typeEntity) {
    XCollectionDataType _instance = this.injector.<XCollectionDataType>getInstance(XCollectionDataType.class);
    PcmRepresentative<CollectionDataType> _setEntity = _instance.setEntity(typeEntity);
    _setEntity.transform();
  }
  
  public void createComponent(final Entity componentEntity) {
    if (componentEntity instanceof BasicComponent) {
      _createComponent((BasicComponent)componentEntity);
      return;
    } else if (componentEntity instanceof CompositeComponent) {
      _createComponent((CompositeComponent)componentEntity);
      return;
    } else if (componentEntity != null) {
      _createComponent(componentEntity);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(componentEntity).toString());
    }
  }
  
  public void createInterface(final Interface interfaceEntity) {
    if (interfaceEntity instanceof EventGroup) {
      _createInterface((EventGroup)interfaceEntity);
      return;
    } else if (interfaceEntity instanceof InfrastructureInterface) {
      _createInterface((InfrastructureInterface)interfaceEntity);
      return;
    } else if (interfaceEntity instanceof OperationInterface) {
      _createInterface((OperationInterface)interfaceEntity);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(interfaceEntity).toString());
    }
  }
  
  public void createDataType(final DataType typeEntity) {
    if (typeEntity instanceof CollectionDataType) {
      _createDataType((CollectionDataType)typeEntity);
      return;
    } else if (typeEntity instanceof CompositeDataType) {
      _createDataType((CompositeDataType)typeEntity);
      return;
    } else if (typeEntity instanceof PrimitiveDataType) {
      _createDataType((PrimitiveDataType)typeEntity);
      return;
    } else if (typeEntity != null) {
      _createDataType(typeEntity);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(typeEntity).toString());
    }
  }
}