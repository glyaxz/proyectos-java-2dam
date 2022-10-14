<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
    <html>
        <xsl:apply-templates />
    </html>
    </xsl:template>
    <xsl-template match="ListaPersonasMunicipio">
    <head>
        <title>
            Lista de personas
        </title>
    </head>
    <body>
        <table border='1'>
            <tr>
                Nombre
            </tr>
            <tr>
                Apellidos
            </tr>
            <th>
                DNI
            </th>
            <th>
                Edad
            </th>

            <xsl:apply-templates select='DatosPersona'/> 
        </table>
    </body>
    </xsl-template>
    <xsl:template match="DatosPersona">
        <tr>
            <xsl:apply-templates />
        </tr>
    </xsl:template>
    <xsl:template match="nombre|apellidos|dni|edad">
        <td>
            <xsl:apply-templates />
        </td>
    </xsl:template>
</xsl:stylesheet>
