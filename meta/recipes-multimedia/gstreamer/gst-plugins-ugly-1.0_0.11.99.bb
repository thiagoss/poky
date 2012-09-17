require gst-plugins-1.0.inc

LICENSE = "GPLv2+ & LGPLv2.1+ & LGPLv2+"
LICENSE_FLAGS = "commercial"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://tests/check/elements/xingmux.c;beginline=1;endline=21;md5=4c771b8af188724855cb99cadd390068"

DEPENDS += "gst-plugins-base-1.0 libid3tag libmad mpeg2dec liba52 lame"
PR = "r0"

SRC_URI = "http://gstreamer.freedesktop.org/src/gst-plugins-ugly/gst-plugins-ugly-${PV}.tar.xz"
S = "${WORKDIR}/gst-plugins-ugly-${PV}"

inherit gettext

EXTRA_OECONF += "--with-plugins=a52dec,lame,id3tag,mad,mpeg2dec,mpegstream,mpegaudioparse,asfdemux,realmedia \
                 --disable-orc"

do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm ${S}/m4/lib-link.m4 || true
}

SRC_URI[md5sum] = "fc20da880285a9a746736028393daaed"
SRC_URI[sha256sum] = "1b9909278a4d22a22f01fd9326737ea3169c7af0bb3f0971e3ddb7c1a7aa829d"

