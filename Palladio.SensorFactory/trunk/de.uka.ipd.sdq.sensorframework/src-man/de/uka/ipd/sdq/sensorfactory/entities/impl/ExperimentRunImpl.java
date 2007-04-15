package de.uka.ipd.sdq.sensorfactory.entities.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

@javax.persistence.Entity
public class ExperimentRunImpl extends de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun {

	@Override
	public SensorAndMeasurements getMeasurementsOfSensor(Sensor sensor) {
		EntityManager em = ExperimentDAO.singleton().getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT m FROM Measurement m WHERE FK_SENSOR = "+sensor.getSensorID());
		Collection <Measurement> result = q.getResultList();
		em.close();
		return new SensorAndMeasurements(sensor,result);
	}
}
