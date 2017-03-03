/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugin.matrixconfigsorter;

import hudson.Extension;
import hudson.matrix.MatrixConfiguration;
import hudson.matrix.MatrixConfigurationSorter;
import hudson.matrix.MatrixConfigurationSorterDescriptor;
import hudson.matrix.MatrixProject;
import hudson.util.FormValidation;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 *
 * @author lucinka
 */
public class ShorterFirstAxisSorter extends MatrixConfigurationSorter{   
    public int compare(MatrixConfiguration configuration1, MatrixConfiguration configuration2) {
        int comparision = Long.compare(configuration1.getEstimatedDuration(), configuration2.getEstimatedDuration());
        if(comparision!=0)
            return comparision;
        return configuration1.getDisplayName().compareTo(configuration2.getDisplayName());
    }

    @DataBoundConstructor
    public ShorterFirstAxisSorter() {
    }


    @Override
    public void validate(MatrixProject p) throws FormValidation {
    }

    @Extension
    public static class DescriptorImpl extends MatrixConfigurationSorterDescriptor {
        @Override
        public String getDisplayName() {
            return "Shortest builds first";
        }
    }
}
