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
public class TimeStampAxisSorter extends MatrixConfigurationSorter{
    public int compare(MatrixConfiguration configuration1, MatrixConfiguration configuration2) {
        Long time = (configuration2.getEstimatedDuration());
        int comparation = time.compareTo(configuration1.getEstimatedDuration());
        if(comparation!=0)
            return comparation;
        return configuration2.getDisplayName().compareTo(configuration1.getDisplayName());
        
    }

    @DataBoundConstructor
    public TimeStampAxisSorter() {
    }
    

    @Override
    public void validate(MatrixProject p) throws FormValidation {
    }

    @Extension
    public static class DescriptorImpl extends MatrixConfigurationSorterDescriptor {
        @Override
        public String getDisplayName() {
            return "Longest builds first";
        }
    }
}
