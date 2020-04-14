package ru.job4j.stream;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfilesTest {

    @Test
    public void profilesReturnListWithAddressFromProfile() {
        Profiles profiles = new Profiles();
        Profile profile = new Profile();
        Address address = profile.getAddress();
        List<Profile> input = new ArrayList<>();
        input.add(profile);
        List<Address> expected = Arrays.asList(address);
        List<Address> result = profiles.collect(input);
        assertThat(result, is(expected));
    }
}
