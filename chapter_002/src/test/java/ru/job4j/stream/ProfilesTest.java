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
        Profile profile = new Profile(null);
        Address address = profile.getAddress();
        List<Profile> input = List.of(profile);
        List<Address> expected = Arrays.asList(address);
        List<Address> result = profiles.collect(input);
        assertThat(result, is(expected));
    }

    @Test
    public void profilesReturnListWithAddressFromProfileSortedByCity() {
        Profiles profiles = new Profiles();
        Address address = new Address("city", "ul", 1, 2);
        Address address2 = new Address("ants", "ul", 1, 2);
        Address address3 = new Address("bang", "ul", 1, 2);
        Address address4 = new Address("bang", "ul", 1, 2);
        List<Profile> input = List.of(
                new Profile(address),
                new Profile(address2),
                new Profile(address3),
                new Profile(address4)
        );
        List<Address> expected = Arrays.asList(address2, address3, address);
        List<Address> result = profiles.collect(input);
        assertThat(result, is(expected));
    }
}
