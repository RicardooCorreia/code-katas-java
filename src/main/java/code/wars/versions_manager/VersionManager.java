package code.wars.versions_manager;

import java.util.Stack;

public class VersionManager {

    private Version version;

    private final Stack<Version> previousVersions = new Stack<>();

    public VersionManager(String initialVersion) {

        String[] versions = initialVersion.split("\\.");
        try {
            int major = 0, minor = 0, patch = 0;
            if (versions.length >= 1 && !versions[0].isBlank()) {
                major = Integer.parseInt(versions[0]);
            }
            if (versions.length >= 2) {
                minor = Integer.parseInt(versions[1]);
            }
            if (versions.length >= 3) {
                patch = Integer.parseInt(versions[2]);
            } else {
                patch = major + minor > 0 ? 0 : 1;
            }
            this.version = new Version(major, minor, patch);
        } catch (Exception ex) {
            throw new RuntimeException("Error occured while parsing version!");
        }
    }

    public VersionManager() {

        this.version = new Version(0, 0, 1);
    }

    public VersionManager major() {

        this.previousVersions.push(version);
        this.version = new Version(this.version.major + 1, 0, 0);
        return this;
    }

    public VersionManager minor() {

        this.previousVersions.push(version);
        this.version = new Version(this.version.major, this.version.minor + 1, 0);
        return this;
    }

    public VersionManager patch() {

        this.previousVersions.push(version);
        this.version = new Version(this.version.major, this.version.minor, this.version.patch + 1);
        return this;
    }

    public VersionManager rollback() {

        if (previousVersions.isEmpty()) {
            throw new RuntimeException("Cannot rollback!");
        }
        this.version = previousVersions.pop();
        return this;
    }

    public String release() {

        return version.toString();
    }

    record Version(int major, int minor, int patch) {

        @Override
        public String toString() {

            return String.join(".", String.valueOf(major), String.valueOf(minor), String.valueOf(patch));
        }
    }
}
