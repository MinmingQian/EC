package adeuni.group.ec.algorithm.utility.factory;

import adeuni.group.ec.algorithm.algorithms.ea.EvolutionaryAlgorithm;
import adeuni.group.ec.algorithm.component.representation.permutation.PermutationRepresentation;
import adeuni.group.ec.algorithm.configuration.Configuration;
import adeuni.group.ec.tests.tsp.TspPermutationEvaluationFunction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by qianminming on 19/08/15.
 */
public class ConfigurationFactoryTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreateConfiguration() throws Exception {
        Configuration configuration = ConfigurationFactory.createConfiguration();
        EvolutionaryAlgorithm algorithm = new EvolutionaryAlgorithm(configuration);

        configuration.setRepresentationFactory(new RepresentationFactory<PermutationRepresentation>(PermutationRepresentation.class, 10));
        configuration.setEvaluationFunction(new TspPermutationEvaluationFunction());

        algorithm.run();
    }
}