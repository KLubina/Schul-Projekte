Grundlegende Vorbereitungen:

1. Installieren Sie Docker und Docker Compose.
 -Stellen Sie sicher, dass Docker und Docker Compose auf Ihrem System installiert sind.

Verzeichnis vorbereiten:
2. Erstellen Sie separate Verzeichnisse für jedes Projekt:
 -MediaWiki, WordPress, JIRA, und ein Verzeichnis für Portainer.

3. Platzieren Sie die entsprechenden docker-compose.yml Dateien in den jeweiligen Verzeichnissen.

Dienste starten:
4. Öffnen Sie ein Terminal oder eine Eingabeaufforderung.
 -Navigieren Sie in das Verzeichnis mit der docker-compose.yml für das gewünschte Projekt.

5. Starten Sie die Dienste für jedes Projekt separat:
 -Führen Sie docker-compose up -d im jeweiligen Verzeichnis aus.

Auf Anwendungen zugreifen:
6. Öffnen Sie einen Webbrowser und navigieren Sie zu:
 -MediaWiki: http://localhost:8080
 -WordPress: http://localhost:8000
 -JIRA: http://localhost:8080
 -Portainer: http://localhost:9000

Dienste verwalten (über Portainer für eine vereinfachte Verwaltung):
7. Erstellen Sie einen Administratorbenutzernamen und ein Passwort bei der ersten Anmeldung bei Portainer.
 -Verwalten Sie alle Docker-Container, -Images, -Netzwerke und -Volumes über die Portainer-Oberfläche.

Dienste verwalten (manuell):
8. Container anzeigen:
 -Verwenden Sie docker-compose ps in jedem Projektverzeichnis, um den Status der Container zu überprüfen.

9. Dienste stoppen und Container entfernen:
 -Führen Sie docker-compose down im jeweiligen Verzeichnis aus, um die Dienste zu stoppen und alle Container zu entfernen