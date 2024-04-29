package razesoldier.epub.reader;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EpubReaderReadManifestTest {
    private EPUBReader reader;

    @BeforeEach
    public void setUp() {
        reader = new EPUBReader("/path/to/valid/epub/file");
    }

    @Test
    public void testReadManifestWithValidFilePath() {
        String content = reader.readManifest("validFilePath");
        assertEquals("ExpectedContent", content);
    }

    @Test
    public void testReadManifestWithInvalidFilePath() {
        assertThrows(NoSuchFileException.class, () -> reader.readManifest("invalidFilePath"));
    }

    @Test
    public void testReadManifestWithEmptyFilePath() {
        assertThrows(IllegalArgumentException.class, () -> reader.readManifest(""));
    }

    @Test
    public void testReadManifestWithNullFilePath() {
        assertThrows(NullPointerException.class, () -> reader.readManifest(null));
    }
}
