require gst-plugins-1.0.inc

LICENSE = "GPLv2+ & LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://common/coverage/coverage-report.pl;beginline=2;endline=17;md5=622921ffad8cb18ab906c56052788a3f \
                    file://gst/replaygain/rganalysis.c;beginline=1;endline=23;md5=b60ebefd5b2f5a8e0cab6bfee391a5fe"

DEPENDS += "gst-plugins-base-1.0 gconf cairo jpeg libpng zlib libid3tag flac \
	    speex libsoup-2.4 pulseaudio"
PR = "r0"

SRC_URI = "http://gstreamer.freedesktop.org/src/gst-plugins-good/gst-plugins-good-${PV}.tar.xz"
S = "${WORKDIR}/gst-plugins-good-${PV}"

inherit gettext gconf

EXTRA_OECONF += "--disable-aalib --disable-esd --disable-shout2 --disable-libcaca --disable-hal --without-check \
                 --disable-orc --disable-examples"

do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm ${S}/m4/lib-link.m4 || true
}

SRC_URI[md5sum] = "762bd204e361a70aa3f262ee8e457519"
SRC_URI[sha256sum] = "760250b3aecbd1da211082dda0e902cae2e460d07e0f1d2952740bf613b18465"

FILES_${PN}-gconfelements += "${sysconfdir}/gconf/schemas/gstreamer-1.0.schemas"
